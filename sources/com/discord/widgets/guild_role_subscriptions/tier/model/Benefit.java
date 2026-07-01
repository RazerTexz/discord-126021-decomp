package com.discord.widgets.guild_role_subscriptions.tier.model;

import android.os.Parcelable;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefit;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Benefit.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Benefit implements Parcelable {
    private Benefit() {
    }

    public boolean equals(Object other) {
        if (other instanceof Benefit) {
            Benefit benefit = (Benefit) other;
            if (m.areEqual(getName(), benefit.getName()) && m.areEqual(getDescription(), benefit.getDescription())) {
                Emoji emoji = getEmoji();
                if (!(emoji instanceof ModelEmojiCustom)) {
                    emoji = null;
                }
                ModelEmojiCustom modelEmojiCustom = (ModelEmojiCustom) emoji;
                Long lValueOf = modelEmojiCustom != null ? Long.valueOf(modelEmojiCustom.getId()) : null;
                Emoji emoji2 = benefit.getEmoji();
                if (!(emoji2 instanceof ModelEmojiCustom)) {
                    emoji2 = null;
                }
                ModelEmojiCustom modelEmojiCustom2 = (ModelEmojiCustom) emoji2;
                if (m.areEqual(lValueOf, modelEmojiCustom2 != null ? Long.valueOf(modelEmojiCustom2.getId()) : null)) {
                    Emoji emoji3 = getEmoji();
                    if (!(emoji3 instanceof ModelEmojiUnicode)) {
                        emoji3 = null;
                    }
                    ModelEmojiUnicode modelEmojiUnicode = (ModelEmojiUnicode) emoji3;
                    String surrogates = modelEmojiUnicode != null ? modelEmojiUnicode.getSurrogates() : null;
                    Emoji emoji4 = benefit.getEmoji();
                    if (!(emoji4 instanceof ModelEmojiUnicode)) {
                        emoji4 = null;
                    }
                    ModelEmojiUnicode modelEmojiUnicode2 = (ModelEmojiUnicode) emoji4;
                    if (m.areEqual(surrogates, modelEmojiUnicode2 != null ? modelEmojiUnicode2.getSurrogates() : null)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public abstract String getDescription();

    public abstract Emoji getEmoji();

    public abstract String getName();

    public abstract GuildRoleSubscriptionBenefit toGuildRoleSubscriptionBenefit();

    public /* synthetic */ Benefit(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
