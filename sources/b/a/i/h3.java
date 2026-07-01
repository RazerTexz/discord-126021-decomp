package b.a.i;

import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.GuildView;

/* JADX INFO: compiled from: ViewServerFolderBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class h3 implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f126b;

    @NonNull
    public final GuildView c;

    @NonNull
    public final GuildView d;

    @NonNull
    public final GuildView e;

    @NonNull
    public final GuildView f;

    @NonNull
    public final GridLayout g;

    public h3(@NonNull View view, @NonNull ImageView imageView, @NonNull GuildView guildView, @NonNull GuildView guildView2, @NonNull GuildView guildView3, @NonNull GuildView guildView4, @NonNull GridLayout gridLayout) {
        this.a = view;
        this.f126b = imageView;
        this.c = guildView;
        this.d = guildView2;
        this.e = guildView3;
        this.f = guildView4;
        this.g = gridLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
