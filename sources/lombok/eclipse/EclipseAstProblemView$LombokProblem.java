package lombok.eclipse;

import org.eclipse.jdt.internal.compiler.problem.DefaultProblem;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/EclipseAstProblemView$LombokProblem.SCL.lombok */
class EclipseAstProblemView$LombokProblem extends DefaultProblem {
    private static final String MARKER_ID = "org.eclipse.jdt.apt.pluggable.core.compileProblem";

    public EclipseAstProblemView$LombokProblem(char[] originatingFileName, String message, int id2, String[] stringArguments, int severity, int startPosition, int endPosition, int line, int column) {
        super(originatingFileName, message, id2, stringArguments, severity, startPosition, endPosition, line, column);
    }

    public int getCategoryID() {
        return 0;
    }

    public String getMarkerType() {
        return MARKER_ID;
    }
}
