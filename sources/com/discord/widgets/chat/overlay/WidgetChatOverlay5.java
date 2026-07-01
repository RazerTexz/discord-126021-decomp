package com.discord.widgets.chat.overlay;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.WidgetChatInputStickerSuggestionsBinding;
import com.discord.R;
import com.discord.databinding.WidgetChatOverlayBinding;
import com.discord.views.sticker.StickerView;
import com.discord.views.typing.TypingDots;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatOverlay5 extends FunctionReferenceImpl implements Function1<View, WidgetChatOverlayBinding> {
    public static final WidgetChatOverlay5 INSTANCE = new WidgetChatOverlay5();

    public WidgetChatOverlay5() {
        super(1, WidgetChatOverlayBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChatOverlayBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChatOverlayBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.chat_overlay_old_messages_fab;
        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.chat_overlay_old_messages_fab);
        if (floatingActionButton != null) {
            i = R.id.chat_overlay_typing;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.chat_overlay_typing);
            if (relativeLayout != null) {
                i = R.id.chat_overlay_typing_dots;
                TypingDots typingDots = (TypingDots) view.findViewById(R.id.chat_overlay_typing_dots);
                if (typingDots != null) {
                    i = R.id.chat_typing_users_slowmode;
                    TextView textView = (TextView) view.findViewById(R.id.chat_typing_users_slowmode);
                    if (textView != null) {
                        i = R.id.chat_typing_users_slowmode_icon;
                        ImageView imageView = (ImageView) view.findViewById(R.id.chat_typing_users_slowmode_icon);
                        if (imageView != null) {
                            i = R.id.chat_typing_users_typing;
                            TextView textView2 = (TextView) view.findViewById(R.id.chat_typing_users_typing);
                            if (textView2 != null) {
                                i = R.id.stickers_suggestions;
                                View viewFindViewById = view.findViewById(R.id.stickers_suggestions);
                                if (viewFindViewById != null) {
                                    int i2 = R.id.chat_input_suggested_sticker_1;
                                    StickerView stickerView = (StickerView) viewFindViewById.findViewById(R.id.chat_input_suggested_sticker_1);
                                    if (stickerView != null) {
                                        i2 = R.id.chat_input_suggested_sticker_2;
                                        StickerView stickerView2 = (StickerView) viewFindViewById.findViewById(R.id.chat_input_suggested_sticker_2);
                                        if (stickerView2 != null) {
                                            i2 = R.id.chat_input_suggested_sticker_3;
                                            StickerView stickerView3 = (StickerView) viewFindViewById.findViewById(R.id.chat_input_suggested_sticker_3);
                                            if (stickerView3 != null) {
                                                i2 = R.id.chat_input_suggested_sticker_4;
                                                StickerView stickerView4 = (StickerView) viewFindViewById.findViewById(R.id.chat_input_suggested_sticker_4);
                                                if (stickerView4 != null) {
                                                    i2 = R.id.chat_input_suggested_sticker_cancel;
                                                    ImageView imageView2 = (ImageView) viewFindViewById.findViewById(R.id.chat_input_suggested_sticker_cancel);
                                                    if (imageView2 != null) {
                                                        return new WidgetChatOverlayBinding((ConstraintLayout) view, floatingActionButton, relativeLayout, typingDots, textView, imageView, textView2, new WidgetChatInputStickerSuggestionsBinding((LinearLayout) viewFindViewById, stickerView, stickerView2, stickerView3, stickerView4, imageView2));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(i2)));
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
