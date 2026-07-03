package p007b.p008a.p009a;

import android.view.View;
import android.widget.LinearLayout;
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
import p007b.p008a.p025i.C1093z;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.m */
/* JADX INFO: compiled from: GuildVideoAtCapacityDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0836m extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f405j = {C1643a.m846d0(C0836m.class, "binding", "getBinding()Lcom/discord/databinding/GuildVideoAtCapacityBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: b.a.a.m$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: GuildVideoAtCapacityDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public final void m140a(FragmentManager fragmentManager) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            new C0836m().show(fragmentManager, C0836m.class.getSimpleName());
        }
    }

    /* JADX INFO: renamed from: b.a.a.m$b */
    /* JADX INFO: compiled from: GuildVideoAtCapacityDialog.kt */
    public static final /* synthetic */ class b extends C12236k implements Function1<View, C1093z> {

        /* JADX INFO: renamed from: j */
        public static final b f408j = new b();

        public b() {
            super(1, C1093z.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GuildVideoAtCapacityBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C1093z invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.guild_video_at_capacity_confirm;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.guild_video_at_capacity_confirm);
            if (materialButton != null) {
                i = C5419R.id.notice_header_container;
                LinearLayout linearLayout = (LinearLayout) view2.findViewById(C5419R.id.notice_header_container);
                if (linearLayout != null) {
                    return new C1093z((LinearLayout) view2, materialButton, linearLayout);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: b.a.a.m$c */
    /* JADX INFO: compiled from: GuildVideoAtCapacityDialog.kt */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            C0836m.this.dismiss();
        }
    }

    public C0836m() {
        super(C5419R.layout.guild_video_at_capacity);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, b.f408j, null, 2, null);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireDialog().setCanceledOnTouchOutside(true);
        ((C1093z) this.binding.getValue((Fragment) this, f405j[0])).f1432b.setOnClickListener(new c());
    }
}
