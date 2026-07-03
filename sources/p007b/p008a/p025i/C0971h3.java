package p007b.p008a.p025i;

import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.GuildView;

/* JADX INFO: renamed from: b.a.i.h3 */
/* JADX INFO: compiled from: ViewServerFolderBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0971h3 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f905a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f906b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final GuildView f907c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final GuildView f908d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final GuildView f909e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final GuildView f910f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final GridLayout f911g;

    public C0971h3(@NonNull View view, @NonNull ImageView imageView, @NonNull GuildView guildView, @NonNull GuildView guildView2, @NonNull GuildView guildView3, @NonNull GuildView guildView4, @NonNull GridLayout gridLayout) {
        this.f905a = view;
        this.f906b = imageView;
        this.f907c = guildView;
        this.f908d = guildView2;
        this.f909e = guildView3;
        this.f910f = guildView4;
        this.f911g = gridLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f905a;
    }
}
