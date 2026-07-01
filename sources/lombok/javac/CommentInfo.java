package lombok.javac;

/* JADX INFO: loaded from: app.apk:lombok/javac/CommentInfo.SCL.lombok */
public final class CommentInfo {
    public final int pos;
    public final int prevEndPos;
    public final String content;
    public final int endPos;
    public final CommentInfo$StartConnection start;
    public final CommentInfo$EndConnection end;

    public CommentInfo(int prevEndPos, int pos, int endPos, String content, CommentInfo$StartConnection start, CommentInfo$EndConnection end) {
        this.pos = pos;
        this.prevEndPos = prevEndPos;
        this.endPos = endPos;
        this.content = content;
        this.start = start;
        this.end = end;
    }

    public boolean isJavadoc() {
        return this.content.startsWith("/**") && this.content.length() > 4;
    }

    public String toString() {
        return String.format("%d: %s (%s,%s)", Integer.valueOf(this.pos), this.content, this.start, this.end);
    }
}
