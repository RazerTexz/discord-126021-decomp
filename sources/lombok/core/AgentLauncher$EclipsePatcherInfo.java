package lombok.core;

/* JADX INFO: loaded from: app.apk:lombok/core/AgentLauncher$EclipsePatcherInfo.SCL.lombok */
class AgentLauncher$EclipsePatcherInfo extends AgentLauncher$AgentInfo {
    private AgentLauncher$EclipsePatcherInfo() {
        super(null);
    }

    /* synthetic */ AgentLauncher$EclipsePatcherInfo(AgentLauncher$EclipsePatcherInfo agentLauncher$EclipsePatcherInfo) {
        this();
    }

    @Override // lombok.core.AgentLauncher$AgentInfo
    String className() {
        return "lombok.eclipse.agent.EclipsePatcher";
    }
}
