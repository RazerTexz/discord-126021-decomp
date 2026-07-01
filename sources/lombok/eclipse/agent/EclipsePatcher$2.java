package lombok.eclipse.agent;

import lombok.patcher.TransplantMapper;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/EclipsePatcher$2.SCL.lombok */
class EclipsePatcher$2 implements TransplantMapper {
    private final /* synthetic */ boolean val$forceBaseResourceNames;

    EclipsePatcher$2(boolean z2) {
        this.val$forceBaseResourceNames = z2;
    }

    @Override // lombok.patcher.TransplantMapper
    public String mapResourceName(int classFileFormatVersion, String resourceName) {
        return (classFileFormatVersion < 50 || this.val$forceBaseResourceNames) ? resourceName : "Class50/" + resourceName;
    }
}
