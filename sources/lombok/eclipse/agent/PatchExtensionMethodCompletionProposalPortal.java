package lombok.eclipse.agent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import lombok.Lombok;
import org.eclipse.jdt.ui.text.java.IJavaCompletionProposal;

/* JADX INFO: loaded from: discord-126021.apk:lombok/eclipse/agent/PatchExtensionMethodCompletionProposalPortal.SCL.lombok */
public class PatchExtensionMethodCompletionProposalPortal {
    private static final String COMPLETION_PROPOSAL_COLLECTOR = "org.eclipse.jdt.ui.text.java.CompletionProposalCollector";
    private static final String I_JAVA_COMPLETION_PROPOSAL_ARRAY = "[Lorg.eclipse.jdt.ui.text.java.IJavaCompletionProposal;";

    public static IJavaCompletionProposal[] getJavaCompletionProposals(Object[] javaCompletionProposals, Object completionProposalCollector) {
        try {
            return (IJavaCompletionProposal[]) ReflectionForUi.getJavaCompletionProposals.invoke(null, javaCompletionProposals, completionProposalCollector);
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (NoClassDefFoundError unused) {
            return (IJavaCompletionProposal[]) javaCompletionProposals;
        } catch (NullPointerException e2) {
            if (!"false".equals(System.getProperty("lombok.debug.reflection", "false"))) {
                e2.initCause(ReflectionForUi.problem);
                throw e2;
            }
            return (IJavaCompletionProposal[]) javaCompletionProposals;
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3.getCause());
        }
    }

    /* JADX INFO: loaded from: discord-126021.apk:lombok/eclipse/agent/PatchExtensionMethodCompletionProposalPortal$ReflectionForUi.SCL.lombok */
    private static final class ReflectionForUi {
        public static final Method getJavaCompletionProposals;
        public static final Throwable problem;

        private ReflectionForUi() {
        }

        static {
            Method p = null;
            Throwable problem_ = null;
            try {
                p = PatchExtensionMethodCompletionProposal.class.getMethod("getJavaCompletionProposals", Class.forName(PatchExtensionMethodCompletionProposalPortal.I_JAVA_COMPLETION_PROPOSAL_ARRAY), Class.forName(PatchExtensionMethodCompletionProposalPortal.COMPLETION_PROPOSAL_COLLECTOR));
            } catch (Throwable t) {
                problem_ = t;
            }
            getJavaCompletionProposals = p;
            problem = problem_;
        }
    }
}
