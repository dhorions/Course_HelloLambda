package be.quodlibet.hellolambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 *
 * @author Dries Horions <dries@quodlibet.be>
 */
public class helloHandler implements RequestHandler<helloInput, helloOutput>
{

    @Override
    public helloOutput handleRequest(helloInput i, Context cntxt)
    {
        helloOutput o = new helloOutput();
        o.setMessage("Hello " + i.getName());
        o.setFunctionName(cntxt.getFunctionName());
        o.setMemoryLimit(cntxt.getMemoryLimitInMB());
        cntxt.getLogger().log(i.getName() + " said hello");
        return o;
    }
}
