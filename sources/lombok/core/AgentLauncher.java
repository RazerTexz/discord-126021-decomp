package lombok.core;

import java.lang.instrument.Instrumentation;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: app.apk:lombok/core/AgentLauncher.SCL.lombok */
public class AgentLauncher {
    private static final List<AgentLauncher$AgentInfo> AGENTS = Collections.unmodifiableList(Arrays.asList(new AgentLauncher$EclipsePatcherInfo(null)));

    public static void runAgents(String agentArgs, Instrumentation instrumentation, boolean injected, Class<?> launchingContext) throws Throwable {
        for (AgentLauncher$AgentInfo info : AGENTS) {
            try {
                Class<?> agentClass = Class.forName(info.className());
                AgentLauncher$AgentLaunchable agent = (AgentLauncher$AgentLaunchable) agentClass.getConstructor(new Class[0]).newInstance(new Object[0]);
                agent.runAgent(agentArgs, instrumentation, injected, launchingContext);
            } catch (Throwable th) {
                t = th;
                if (t instanceof InvocationTargetException) {
                    t = t.getCause();
                }
                info.problem(t, instrumentation);
            }
        }
    }
}
