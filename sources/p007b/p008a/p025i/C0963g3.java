package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.viewbinding.ViewBinding;
import com.discord.views.GuildView;
import com.discord.views.guilds.ServerMemberCount;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.g3 */
/* JADX INFO: compiled from: ViewServerDiscoveryItemBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0963g3 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f867a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f868b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f869c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ServerMemberCount f870d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f871e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final GuildView f872f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f873g;

    public C0963g3(@NonNull View view, @NonNull Barrier barrier, @NonNull Barrier barrier2, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull ServerMemberCount serverMemberCount, @NonNull TextView textView, @NonNull GuildView guildView, @NonNull TextView textView2) {
        this.f867a = view;
        this.f868b = materialButton;
        this.f869c = materialButton2;
        this.f870d = serverMemberCount;
        this.f871e = textView;
        this.f872f = guildView;
        this.f873g = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f867a;
    }
}
