package lombok.eclipse.agent;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchExtensionMethodCompletionProposalPortal$ReflectionForUi.SCL.lombok */
final class PatchExtensionMethodCompletionProposalPortal$ReflectionForUi {
    public static final Method getJavaCompletionProposals;
    public static final Throwable problem;

    private PatchExtensionMethodCompletionProposalPortal$ReflectionForUi() {
    }

    static {
        Method p = null;
        Throwable problem_ = null;
        try {
            p = PatchExtensionMethodCompletionProposal.class.getMethod("getJavaCompletionProposals", Class.forName("[Lorg.eclipse.jdt.ui.text.java.IJavaCompletionProposal;"), Class.forName("org.eclipse.jdt.ui.text.java.CompletionProposalCollector"));
        } catch (Throwable t) {
            problem_ = t;
        }
        getJavaCompletionProposals = p;
        problem = problem_;
    }
}
