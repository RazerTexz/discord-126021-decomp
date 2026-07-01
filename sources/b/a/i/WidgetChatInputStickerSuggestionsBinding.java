package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.sticker.StickerView;

/* JADX INFO: renamed from: b.a.i.x4, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatInputStickerSuggestionsBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatInputStickerSuggestionsBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final StickerView f230b;

    @NonNull
    public final StickerView c;

    @NonNull
    public final StickerView d;

    @NonNull
    public final StickerView e;

    @NonNull
    public final ImageView f;

    public WidgetChatInputStickerSuggestionsBinding(@NonNull LinearLayout linearLayout, @NonNull StickerView stickerView, @NonNull StickerView stickerView2, @NonNull StickerView stickerView3, @NonNull StickerView stickerView4, @NonNull ImageView imageView) {
        this.a = linearLayout;
        this.f230b = stickerView;
        this.c = stickerView2;
        this.d = stickerView3;
        this.e = stickerView4;
        this.f = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
