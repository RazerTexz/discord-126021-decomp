package com.discord.views;

import android.content.res.ColorStateList;
import android.widget.ImageView;
import android.widget.TextView;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.audio.DiscordAudioManager$DeviceTypes;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.voice.VoiceViewUtils;
import d0.z.d.m;
import d0.z.d.o;
import defpackage.f;
import defpackage.i;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: OverlayMenuView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OverlayMenuView$b extends o implements Function1<OverlayMenuView$a, Unit> {
    public final /* synthetic */ OverlayMenuView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayMenuView$b(OverlayMenuView overlayMenuView) {
        super(1);
        this.this$0 = overlayMenuView;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(OverlayMenuView$a overlayMenuView$a) {
        OverlayMenuView$a overlayMenuView$a2 = overlayMenuView$a;
        if (overlayMenuView$a2 != null) {
            OverlayMenuView overlayMenuView = this.this$0;
            int i = OverlayMenuView.j;
            Objects.requireNonNull(overlayMenuView);
            if (overlayMenuView$a2.c != null) {
                overlayMenuView.binding.f197b.d.setOnClickListener(new f(0, overlayMenuView, overlayMenuView$a2));
                TextView textView = overlayMenuView.binding.f197b.d;
                m.checkNotNullExpressionValue(textView, "binding.content.overlayInviteLink");
                textView.setVisibility(PermissionUtils.can(1L, overlayMenuView$a2.a) ? 0 : 8);
                overlayMenuView.binding.f197b.g.setOnClickListener(new i(0, overlayMenuView));
                overlayMenuView.binding.f197b.f.setOnClickListener(new f(1, overlayMenuView, overlayMenuView$a2));
                ImageView imageView = overlayMenuView.binding.e;
                m.checkNotNullExpressionValue(imageView, "binding.srcToggle");
                ColorStateList colorStateListValueOf = overlayMenuView$a2.c.getAudioManagerState().getActiveAudioDevice() == DiscordAudioManager$DeviceTypes.SPEAKERPHONE ? ColorStateList.valueOf(-1) : ColorStateList.valueOf(ColorCompat.getColor(overlayMenuView.getContext(), 2131100213));
                m.checkNotNullExpressionValue(colorStateListValueOf, "if (selectedOutputDevice…rimary_dark_400))\n      }");
                imageView.setImageTintList(colorStateListValueOf);
                overlayMenuView.binding.e.setOnClickListener(new i(1, overlayMenuView$a2));
                ImageView imageView2 = overlayMenuView.binding.d;
                m.checkNotNullExpressionValue(imageView2, "binding.muteToggle");
                imageView2.setActivated(overlayMenuView$a2.c.isMeMutedByAnySource());
                overlayMenuView.binding.d.setOnClickListener(new i(2, overlayMenuView$a2));
                overlayMenuView.binding.c.setOnClickListener(new i(3, overlayMenuView));
                overlayMenuView.binding.f197b.e.setImageResource(VoiceViewUtils.INSTANCE.getQualityIndicator(overlayMenuView$a2.d));
                TextView textView2 = overlayMenuView.binding.f197b.c;
                m.checkNotNullExpressionValue(textView2, "binding.content.overlayGuildName");
                Guild guild = overlayMenuView$a2.f2833b;
                String name = guild != null ? guild.getName() : null;
                if (name == null) {
                    name = "";
                }
                textView2.setText(name);
                TextView textView3 = overlayMenuView.binding.f197b.f203b;
                m.checkNotNullExpressionValue(textView3, "binding.content.overlayChannelName");
                textView3.setText(ChannelUtils.c(overlayMenuView$a2.c.getChannel()));
            }
        }
        return Unit.a;
    }
}
