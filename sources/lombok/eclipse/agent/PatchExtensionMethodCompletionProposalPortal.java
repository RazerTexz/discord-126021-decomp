package lombok.eclipse.agent;

import java.lang.reflect.InvocationTargetException;
import lombok.Lombok;
import org.eclipse.jdt.ui.text.java.IJavaCompletionProposal;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchExtensionMethodCompletionProposalPortal.SCL.lombok */
public class PatchExtensionMethodCompletionProposalPortal {
    private static final String COMPLETION_PROPOSAL_COLLECTOR = "org.eclipse.jdt.ui.text.java.CompletionProposalCollector";
    private static final String I_JAVA_COMPLETION_PROPOSAL_ARRAY = "[Lorg.eclipse.jdt.ui.text.java.IJavaCompletionProposal;";

    public static IJavaCompletionProposal[] getJavaCompletionProposals(Object[] javaCompletionProposals, Object completionProposalCollector) {
        try {
            return (IJavaCompletionProposal[]) PatchExtensionMethodCompletionProposalPortal$ReflectionForUi.getJavaCompletionProposals.invoke(null, javaCompletionProposals, completionProposalCollector);
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (NoClassDefFoundError unused) {
            return (IJavaCompletionProposal[]) javaCompletionProposals;
        } catch (NullPointerException e2) {
            if (!"false".equals(System.getProperty("lombok.debug.reflection", "false"))) {
                e2.initCause(PatchExtensionMethodCompletionProposalPortal$ReflectionForUi.problem);
                throw e2;
            }
            return (IJavaCompletionProposal[]) javaCompletionProposals;
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3.getCause());
        }
    }
}
