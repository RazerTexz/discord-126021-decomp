package androidx.activity;

/* JADX INFO: loaded from: classes.dex */
public class OnBackPressedDispatcher$OnBackPressedCancellable implements Cancellable {
    private final OnBackPressedCallback mOnBackPressedCallback;
    public final /* synthetic */ OnBackPressedDispatcher this$0;

    public OnBackPressedDispatcher$OnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, OnBackPressedCallback onBackPressedCallback) {
        this.this$0 = onBackPressedDispatcher;
        this.mOnBackPressedCallback = onBackPressedCallback;
    }

    @Override // androidx.activity.Cancellable
    public void cancel() {
        this.this$0.mOnBackPressedCallbacks.remove(this.mOnBackPressedCallback);
        this.mOnBackPressedCallback.removeCancellable(this);
    }
}
