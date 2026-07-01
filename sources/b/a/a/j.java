package b.a.a;

import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: CameraCapacityDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class j extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {a.d0(j.class, "binding", "getBinding()Lcom/discord/databinding/CameraCapacityDialogBinding;", 0)};
    public static final j$a k = new j$a(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    public j() {
        super(R$layout.camera_capacity_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, j$b.j, null, 2, null);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireDialog().setCanceledOnTouchOutside(true);
        FragmentViewBindingDelegate fragmentViewBindingDelegate = this.binding;
        KProperty<?>[] kPropertyArr = j;
        ((b.a.i.e) fragmentViewBindingDelegate.getValue((Fragment) this, kPropertyArr[0])).c.setOnClickListener(new j$c(this));
        Bundle arguments = getArguments();
        Integer numValueOf = arguments != null ? Integer.valueOf(arguments.getInt("ARG_MAX_VIDEO_CHANNEL_USERS")) : null;
        TextView textView = ((b.a.i.e) this.binding.getValue((Fragment) this, kPropertyArr[0])).f102b;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.cameraCapacityBody");
        textView.setText(b.k(this, 2131897113, new Object[]{String.valueOf(numValueOf)}, null, 4));
    }
}
