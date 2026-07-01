package b.a.a;

import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: GuildVideoAtCapacityDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class m extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {a.d0(m.class, "binding", "getBinding()Lcom/discord/databinding/GuildVideoAtCapacityBinding;", 0)};
    public static final m$a k = new m$a(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    public m() {
        super(R$layout.guild_video_at_capacity);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, m$b.j, null, 2, null);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireDialog().setCanceledOnTouchOutside(true);
        ((b.a.i.z) this.binding.getValue((Fragment) this, j[0])).f238b.setOnClickListener(new m$c(this));
    }
}
