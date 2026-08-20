package lombok.javac;

/* JADX INFO: loaded from: discord-126021.apk:lombok/javac/CommentInfo$EndConnection.SCL.lombok */
public enum CommentInfo$EndConnection {
    DIRECT_AFTER_COMMENT,
    AFTER_COMMENT,
    ON_NEXT_LINE;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static CommentInfo$EndConnection[] valuesCustom() {
        CommentInfo$EndConnection[] commentInfo$EndConnectionArrValuesCustom = values();
        int length = commentInfo$EndConnectionArrValuesCustom.length;
        CommentInfo$EndConnection[] commentInfo$EndConnectionArr = new CommentInfo$EndConnection[length];
        System.arraycopy(commentInfo$EndConnectionArrValuesCustom, 0, commentInfo$EndConnectionArr, 0, length);
        return commentInfo$EndConnectionArr;
    }
}
