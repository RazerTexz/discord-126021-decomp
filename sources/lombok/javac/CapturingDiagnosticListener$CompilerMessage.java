package lombok.javac;

/* JADX INFO: loaded from: app.apk:lombok/javac/CapturingDiagnosticListener$CompilerMessage.SCL.lombok */
public final class CapturingDiagnosticListener$CompilerMessage {
    private final long line;
    private final long position;
    private final boolean isError;
    private final String message;

    public CapturingDiagnosticListener$CompilerMessage(long line, long position, boolean isError, String message) {
        this.line = line;
        this.position = position;
        this.isError = isError;
        this.message = message;
    }

    public long getLine() {
        return this.line;
    }

    public long getPosition() {
        return this.position;
    }

    public boolean isError() {
        return this.isError;
    }

    public String getMessage() {
        return this.message;
    }

    public int hashCode() {
        int result = (31 * 1) + (this.isError ? 1231 : 1237);
        return (31 * ((31 * result) + ((int) (this.line ^ (this.line >>> 32))))) + (this.message == null ? 0 : this.message.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CapturingDiagnosticListener$CompilerMessage other = (CapturingDiagnosticListener$CompilerMessage) obj;
        if (this.isError != other.isError || this.line != other.line) {
            return false;
        }
        if (this.message == null) {
            return other.message == null;
        }
        return this.message.equals(other.message);
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(this.line);
        objArr[1] = this.isError ? "ERROR" : "WARNING";
        objArr[2] = this.message;
        return String.format("%d %s %s", objArr);
    }
}
