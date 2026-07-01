package b.a.a.d;

import java.util.Objects;

/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a$e<T, R> implements j0.k.b<Object, T> {
    public static final a$e j = new a$e();

    @Override // j0.k.b
    public final T call(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.dialogs.useractions.UserActionsDialogViewModel.ViewState.Loaded");
        return (T) ((f$d$a) obj);
    }
}
