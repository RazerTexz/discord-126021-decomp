package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.FailedUploadView;

/* JADX INFO: renamed from: b.a.i.d2, reason: use source file name */
/* JADX INFO: compiled from: ViewChatUploadListBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewChatUploadListBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FailedUploadView f98b;

    @NonNull
    public final FailedUploadView c;

    @NonNull
    public final FailedUploadView d;

    public ViewChatUploadListBinding(@NonNull LinearLayout linearLayout, @NonNull FailedUploadView failedUploadView, @NonNull FailedUploadView failedUploadView2, @NonNull FailedUploadView failedUploadView3) {
        this.a = linearLayout;
        this.f98b = failedUploadView;
        this.c = failedUploadView2;
        this.d = failedUploadView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
