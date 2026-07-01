package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.roles.RoleIconView;

/* JADX INFO: renamed from: b.a.i.y, reason: use source file name */
/* JADX INFO: compiled from: GuildRoleChipBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class GuildRoleChipBinding implements ViewBinding {

    @NonNull
    public final CardView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f232b;

    @NonNull
    public final RoleIconView c;

    @NonNull
    public final TextView d;

    public GuildRoleChipBinding(@NonNull CardView cardView, @NonNull ImageView imageView, @NonNull RoleIconView roleIconView, @NonNull TextView textView) {
        this.a = cardView;
        this.f232b = imageView;
        this.c = roleIconView;
        this.d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
