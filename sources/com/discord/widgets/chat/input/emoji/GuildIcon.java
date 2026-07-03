package com.discord.widgets.chat.input.emoji;

import android.content.Context;
import android.util.AttributeSet;
import com.discord.models.guild.Guild;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildIcon.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildIcon extends SimpleDraweeView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildIcon(Context context) {
        super(context);
        C12238m.checkNotNullParameter(context, "context");
    }

    public final void updateView(Guild guild) {
        C12238m.checkNotNullParameter(guild, "guild");
        if (guild.hasIcon()) {
            int mediaProxySize = IconUtils.getMediaProxySize(getLayoutParams().width);
            MGImages.setImage$default(this, C12238m.stringPlus(IconUtils.getForGuild$default(guild, null, false, null, 10, null), "?size=" + mediaProxySize), getLayoutParams().width, getLayoutParams().height, false, null, null, 112, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildIcon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildIcon(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildIcon(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C12238m.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildIcon(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
