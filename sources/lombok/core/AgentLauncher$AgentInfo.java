package lombok.core;

import java.lang.instrument.Instrumentation;

/* JADX INFO: loaded from: app.apk:lombok/core/AgentLauncher$AgentInfo.SCL.lombok */
abstract class AgentLauncher$AgentInfo {
    abstract String className();

    private AgentLauncher$AgentInfo() {
    }

    /* synthetic */ AgentLauncher$AgentInfo(AgentLauncher$AgentInfo agentLauncher$AgentInfo) {
        this();
    }

    void problem(Throwable t, Instrumentation instrumentation) throws Throwable {
        if (t instanceof ClassNotFoundException) {
            return;
        }
        if (t instanceof ClassCastException) {
            throw new InternalError("Lombok bug. Class: " + className() + " is not an implementation of lombok.core.Agent");
        }
        if (t instanceof IllegalAccessError) {
            throw new InternalError("Lombok bug. Class: " + className() + " is not public");
        }
        if (t instanceof InstantiationException) {
            throw new InternalError("Lombok bug. Class: " + className() + " is not concrete or has no public no-args constructor");
        }
        throw t;
    }
}
