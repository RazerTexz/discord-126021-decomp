package com.discord.views;

import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection$Quality;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.m;

/* JADX INFO: compiled from: OverlayMenuView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OverlayMenuView$a {
    public final Long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Guild f2833b;
    public final CallModel c;
    public final RtcConnection$Quality d;

    public OverlayMenuView$a(Long l, Guild guild, CallModel callModel, RtcConnection$Quality rtcConnection$Quality) {
        m.checkNotNullParameter(rtcConnection$Quality, "rtcQuality");
        this.a = l;
        this.f2833b = guild;
        this.c = callModel;
        this.d = rtcConnection$Quality;
    }
}
