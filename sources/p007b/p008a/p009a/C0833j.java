package p007b.p008a.p009a;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p025i.C0943e;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.j */
/* JADX INFO: compiled from: CameraCapacityDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0833j extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f391j = {C1643a.m846d0(C0833j.class, "binding", "getBinding()Lcom/discord/databinding/CameraCapacityDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: b.a.a.j$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: CameraCapacityDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public final void m137a(FragmentManager fragmentManager, int i) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            Bundle bundle = new Bundle();
            bundle.putInt("ARG_MAX_VIDEO_CHANNEL_USERS", i);
            C0833j c0833j = new C0833j();
            c0833j.setArguments(bundle);
            c0833j.show(fragmentManager, C0833j.class.getSimpleName());
        }
    }

    /* JADX INFO: renamed from: b.a.a.j$b */
    /* JADX INFO: compiled from: CameraCapacityDialog.kt */
    public static final /* synthetic */ class b extends C12236k implements Function1<View, C0943e> {

        /* JADX INFO: renamed from: j */
        public static final b f394j = new b();

        public b() {
            super(1, C0943e.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/CameraCapacityDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C0943e invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.camera_capacity_body;
            TextView textView = (TextView) view2.findViewById(C5419R.id.camera_capacity_body);
            if (textView != null) {
                i = C5419R.id.camera_capacity_confirm;
                MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.camera_capacity_confirm);
                if (materialButton != null) {
                    i = C5419R.id.notice_header_container;
                    LinearLayout linearLayout = (LinearLayout) view2.findViewById(C5419R.id.notice_header_container);
                    if (linearLayout != null) {
                        return new C0943e((LinearLayout) view2, textView, materialButton, linearLayout);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: b.a.a.j$c */
    /* JADX INFO: compiled from: CameraCapacityDialog.kt */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            C0833j.this.dismiss();
        }
    }

    public C0833j() {
        super(C5419R.layout.camera_capacity_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, b.f394j, null, 2, null);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireDialog().setCanceledOnTouchOutside(true);
        FragmentViewBindingDelegate fragmentViewBindingDelegate = this.binding;
        KProperty<?>[] kPropertyArr = f391j;
        ((C0943e) fragmentViewBindingDelegate.getValue((Fragment) this, kPropertyArr[0])).f803c.setOnClickListener(new c());
        Bundle arguments = getArguments();
        Integer numValueOf = arguments != null ? Integer.valueOf(arguments.getInt("ARG_MAX_VIDEO_CHANNEL_USERS")) : null;
        TextView textView = ((C0943e) this.binding.getValue((Fragment) this, kPropertyArr[0])).f802b;
        C12238m.checkNotNullExpressionValue(textView, "binding.cameraCapacityBody");
        textView.setText(C1107b.m213e(this, C5419R.string.video_capacity_modal_body, new Object[]{String.valueOf(numValueOf)}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
    }
}
