package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.FailedUploadView;

/* JADX INFO: renamed from: b.a.i.d2 */
/* JADX INFO: compiled from: ViewChatUploadListBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0938d2 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f778a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final FailedUploadView f779b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final FailedUploadView f780c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final FailedUploadView f781d;

    public C0938d2(@NonNull LinearLayout linearLayout, @NonNull FailedUploadView failedUploadView, @NonNull FailedUploadView failedUploadView2, @NonNull FailedUploadView failedUploadView3) {
        this.f778a = linearLayout;
        this.f779b = failedUploadView;
        this.f780c = failedUploadView2;
        this.f781d = failedUploadView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f778a;
    }
}
