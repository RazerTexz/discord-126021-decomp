package lombok.eclipse;

import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.impl.ReferenceContext;
import org.eclipse.jdt.internal.compiler.util.Util;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/EclipseAstProblemView.SCL.lombok */
public class EclipseAstProblemView {
    public static void addProblemToCompilationResult(char[] fileNameArray, CompilationResult result, boolean isWarning, String message, int sourceStart, int sourceEnd) {
        int lineNumber;
        int iSearchColumnNumber;
        if (result == null) {
            return;
        }
        if (fileNameArray == null) {
            fileNameArray = "(unknown).java".toCharArray();
        }
        if (sourceStart >= 0) {
            int[] lineEnds = result.getLineSeparatorPositions();
            lineNumber = Util.getLineNumber(sourceStart, lineEnds, 0, lineEnds.length - 1);
        } else {
            lineNumber = 0;
        }
        int lineNumber2 = lineNumber;
        if (sourceStart >= 0) {
            iSearchColumnNumber = Util.searchColumnNumber(result.getLineSeparatorPositions(), lineNumber2, sourceStart);
        } else {
            iSearchColumnNumber = 0;
        }
        int columnNumber = iSearchColumnNumber;
        result.record(new EclipseAstProblemView$LombokProblem(fileNameArray, message, 0, new String[0], isWarning ? 0 : 1, sourceStart, sourceEnd, lineNumber2, columnNumber), (ReferenceContext) null);
    }
}
