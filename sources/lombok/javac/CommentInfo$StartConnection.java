package lombok.javac;

/* JADX INFO: loaded from: app.apk:lombok/javac/CommentInfo$StartConnection.SCL.lombok */
public enum CommentInfo$StartConnection {
    START_OF_LINE,
    ON_NEXT_LINE,
    DIRECT_AFTER_PREVIOUS,
    AFTER_PREVIOUS;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static CommentInfo$StartConnection[] valuesCustom() {
        CommentInfo$StartConnection[] commentInfo$StartConnectionArrValuesCustom = values();
        int length = commentInfo$StartConnectionArrValuesCustom.length;
        CommentInfo$StartConnection[] commentInfo$StartConnectionArr = new CommentInfo$StartConnection[length];
        System.arraycopy(commentInfo$StartConnectionArrValuesCustom, 0, commentInfo$StartConnectionArr, 0, length);
        return commentInfo$StartConnectionArr;
    }
}
