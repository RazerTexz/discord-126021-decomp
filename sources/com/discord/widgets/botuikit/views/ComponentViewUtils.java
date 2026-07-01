package com.discord.widgets.botuikit.views;

import com.discord.R$string;
import com.discord.api.botuikit.ComponentEmoji;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.stores.StoreStream;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.s;
import d0.z.d.m;

/* JADX INFO: compiled from: ComponentViewUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ComponentViewUtils {
    public static final ComponentViewUtils INSTANCE = new ComponentViewUtils();

    private ComponentViewUtils() {
    }

    public final void setEmojiOrHide(SimpleDraweeView simpleDraweeView, ComponentEmoji componentEmoji, boolean z2) {
        String imageUri;
        m.checkNotNullParameter(simpleDraweeView, "$this$setEmojiOrHide");
        if (componentEmoji == null) {
            simpleDraweeView.setVisibility(8);
            return;
        }
        boolean z3 = false;
        simpleDraweeView.setVisibility(0);
        String id2 = componentEmoji.getId();
        Long longOrNull = id2 != null ? s.toLongOrNull(id2) : null;
        if (longOrNull != null) {
            long jLongValue = longOrNull.longValue();
            if (z2 && m.areEqual(componentEmoji.getAnimated(), Boolean.TRUE)) {
                z3 = true;
            }
            imageUri = ModelEmojiCustom.getImageUri(jLongValue, z3, 64);
        } else {
            ModelEmojiUnicode modelEmojiUnicode = StoreStream.Companion.getEmojis().getUnicodeEmojiSurrogateMap().get(componentEmoji.getName());
            imageUri = ModelEmojiUnicode.getImageUri(modelEmojiUnicode != null ? modelEmojiUnicode.getCodePoints() : null, simpleDraweeView.getContext());
        }
        if (!m.areEqual(simpleDraweeView.getTag(R$string.tag_emoji_url), imageUri)) {
            simpleDraweeView.setTag(R$string.tag_emoji_url, imageUri);
            MGImages.setImage$default(simpleDraweeView, imageUri, 2131165401, 2131165401, true, null, null, 96, null);
        }
    }
}
