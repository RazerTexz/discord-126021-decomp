package rx.exceptions;

/* JADX INFO: loaded from: classes3.dex */
public final class CompositeException$a extends RuntimeException {
    private static final long serialVersionUID = 3875212506787802066L;

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Chain of Causes for CompositeException In Order Received =>";
    }
}
