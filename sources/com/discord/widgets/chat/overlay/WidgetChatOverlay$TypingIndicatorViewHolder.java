package com.discord.widgets.chat.overlay;

import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.k.b;
import com.discord.databinding.WidgetChatOverlayBinding;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.typing.TypingDots;
import d0.g0.t;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetChatOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatOverlay$TypingIndicatorViewHolder {
    private final WidgetChatOverlayBinding binding;

    public WidgetChatOverlay$TypingIndicatorViewHolder(WidgetChatOverlayBinding widgetChatOverlayBinding) {
        m.checkNotNullParameter(widgetChatOverlayBinding, "binding");
        this.binding = widgetChatOverlayBinding;
    }

    private final void configureTyping(ChatTypingModel$Typing model) {
        if (model.getTypingUsers().isEmpty() && model.getChannelRateLimit() <= 0) {
            this.binding.d.c();
            RelativeLayout relativeLayout = this.binding.c;
            m.checkNotNullExpressionValue(relativeLayout, "binding.chatOverlayTyping");
            relativeLayout.setVisibility(8);
            return;
        }
        RelativeLayout relativeLayout2 = this.binding.c;
        m.checkNotNullExpressionValue(relativeLayout2, "binding.chatOverlayTyping");
        relativeLayout2.setVisibility(0);
        ConstraintLayout constraintLayout = this.binding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        Resources resources = constraintLayout.getResources();
        m.checkNotNullExpressionValue(resources, "binding.root.resources");
        CharSequence typingString = getTypingString(resources, model.getTypingUsers());
        CharSequence slowmodeText = getSlowmodeText(model.getCooldownSecs(), model.getChannelRateLimit(), !t.isBlank(typingString));
        TextView textView = this.binding.g;
        m.checkNotNullExpressionValue(textView, "binding.chatTypingUsersTyping");
        ViewExtensions.setTextAndVisibilityBy(textView, typingString);
        TypingDots typingDots = this.binding.d;
        m.checkNotNullExpressionValue(typingDots, "binding.chatOverlayTypingDots");
        typingDots.setVisibility(model.getTypingUsers().isEmpty() ^ true ? 0 : 8);
        TypingDots typingDots2 = this.binding.d;
        if (!model.getTypingUsers().isEmpty()) {
            TypingDots.b(typingDots2, false, 1);
        } else {
            typingDots2.c();
        }
        TextView textView2 = this.binding.e;
        m.checkNotNullExpressionValue(textView2, "binding.chatTypingUsersSlowmode");
        ViewExtensions.setTextAndVisibilityBy(textView2, slowmodeText);
        ImageView imageView = this.binding.f;
        m.checkNotNullExpressionValue(imageView, "binding.chatTypingUsersSlowmodeIcon");
        imageView.setVisibility(model.getChannelRateLimit() > 0 ? 0 : 8);
    }

    private final CharSequence getSlowmodeText(int cooldownSecs, int channelRateLimit, boolean hasTypingText) {
        if (cooldownSecs > 0) {
            return TimeUtils.toFriendlyStringSimple$default(TimeUtils.INSTANCE, 1000 * ((long) cooldownSecs), null, null, 6, null);
        }
        if (channelRateLimit <= 0 || hasTypingText) {
            return "";
        }
        ConstraintLayout constraintLayout = this.binding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        String string = constraintLayout.getResources().getString(2131887611);
        m.checkNotNullExpressionValue(string, "binding.root.resources.g…nnel_slowmode_desc_short)");
        return string;
    }

    private final CharSequence getTypingString(Resources resources, List<? extends CharSequence> typingUsers) {
        int size = typingUsers.size();
        if (size == 0) {
            return "";
        }
        if (size == 1) {
            return b.i(resources, 2131893511, new Object[]{typingUsers.get(0)}, null, 4);
        }
        if (size != 2) {
            return size != 3 ? b.i(resources, 2131895640, new Object[0], null, 4) : b.i(resources, 2131896400, new Object[]{typingUsers.get(0), typingUsers.get(1), typingUsers.get(2)}, null, 4);
        }
        return b.i(resources, 2131896548, new Object[]{typingUsers.get(0), typingUsers.get(1)}, null, 4);
    }

    public final void configureUI(ChatTypingModel model) {
        m.checkNotNullParameter(model, "model");
        if (model instanceof ChatTypingModel$Hide) {
            RelativeLayout relativeLayout = this.binding.c;
            m.checkNotNullExpressionValue(relativeLayout, "binding.chatOverlayTyping");
            relativeLayout.setVisibility(8);
        } else if (model instanceof ChatTypingModel$Typing) {
            configureTyping((ChatTypingModel$Typing) model);
        }
    }
}
