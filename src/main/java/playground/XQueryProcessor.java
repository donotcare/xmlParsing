package playground;


import net.sf.saxon.xqj.SaxonXQDataSource;

import javax.xml.xquery.*;

public class XQueryProcessor {
    private final XQDataSource xqDataSource = new SaxonXQDataSource();

    public XQResultSequence evaluate(String expression) throws XQException {
        XQConnection connection = xqDataSource.getConnection();
        XQPreparedExpression xqExpression = connection.prepareExpression(expression);
        return xqExpression.executeQuery();
    }
}
