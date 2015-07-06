package message.mybatis.pagination;

import message.base.pagination.Pageable;
import message.base.pagination.PaginationSupport;
import message.base.pagination.PaginationUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * mybatis分页使用的拦截器.
 *
 * @author sunhao(sunhao.java@gmail.com)
 * @version V1.0, 15/6/25 下午7:28
 */
@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {
                MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class
        })
})
public class PaginationInterceptor implements Interceptor {
    private static final Integer MAPPED_STATEMENT_INDEX = 0;
    private static final Integer PARAMETER_INDEX = 1;
    private static int ROWBOUNDS_INDEX = 2;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] queryArgs = invocation.getArgs();
        Object parameter = queryArgs[PARAMETER_INDEX];

        //在参数中获取分页的信息
        Pageable pageable = PaginationHelper.findObjectFromParameter(parameter, Pageable.class);
        if (pageable == null) {
            //无需分页
            return invocation.proceed();
        }

        final MappedStatement ms = (MappedStatement) queryArgs[MAPPED_STATEMENT_INDEX];
        final BoundSql boundSql = ms.getBoundSql(parameter);
        String sql = boundSql.getSql();
        int total = PaginationHelper.queryForTotal(sql, ms, boundSql);

        //分页语句
        String pageSql = PaginationHelper.getPageSql(sql, pageable.getStart(), pageable.getNum());

        queryArgs[ROWBOUNDS_INDEX] = new RowBounds(RowBounds.NO_ROW_OFFSET, RowBounds.NO_ROW_LIMIT);
        queryArgs[MAPPED_STATEMENT_INDEX] = PaginationHelper.copyFromNewSql(ms, boundSql, pageSql);

        Object ret = invocation.proceed();
        PaginationSupport<?> ps = PaginationUtils.makePagination((List<?>) ret, total, pageable.getNum(), pageable.getStart());

        List<PaginationSupport<?>> result = new ArrayList<PaginationSupport<?>>();
        result.add(ps);

        return result;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
//        SqlHelper sqlHelper = ApplicationHelper.getInstance().getBean(SqlHelper.class);
//        PaginationHelper.setSqlHelper(sqlHelper);
    }
}
