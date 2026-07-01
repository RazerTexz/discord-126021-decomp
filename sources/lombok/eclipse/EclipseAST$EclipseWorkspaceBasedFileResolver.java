package lombok.eclipse;

import java.net.URI;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/EclipseAST$EclipseWorkspaceBasedFileResolver.SCL.lombok */
class EclipseAST$EclipseWorkspaceBasedFileResolver {
    private EclipseAST$EclipseWorkspaceBasedFileResolver() {
    }

    public static URI resolve(String path) {
        if (path == null || path.indexOf(47, 1) == -1) {
            return null;
        }
        try {
            return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path)).getLocationURI();
        } catch (Exception unused) {
            return null;
        }
    }
}
