package lombok.eclipse.agent;

import java.net.URLClassLoader;
import java.security.ProtectionDomain;
import lombok.patcher.Filter;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/EclipsePatcher$1.SCL.lombok */
class EclipsePatcher$1 implements Filter {
    EclipsePatcher$1() {
    }

    @Override // lombok.patcher.Filter
    public boolean shouldTransform(ClassLoader loader, String className, Class<?> classBeingDefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        ClassLoader parent;
        if (loader == null || !loader.getClass().getName().startsWith("org.sonar.classloader.")) {
            return ((loader instanceof URLClassLoader) && (parent = loader.getParent()) != null && parent.getClass().getName().startsWith("org.eclipse.jdt.apt.core.internal.AnnotationProcessorFactoryLoader")) ? false : true;
        }
        return false;
    }
}
