package com.discord.utilities.search.strings;

import android.content.Context;
import d0.z.d.m;

/* JADX INFO: compiled from: ContextSearchStringProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContextSearchStringProvider implements SearchStringProvider {
    private final String embedAnswerString;
    private final String fileAnswerString;
    private final String fromFilterString;
    private final String hasFilterString;
    private final String imageAnswerString;
    private final String inFilterString;
    private final String linkAnswerString;
    private final String mentionsFilterString;
    private final String soundAnswerString;
    private final String stickerAnswerString;
    private final String videoAnswerString;

    public ContextSearchStringProvider(Context context) {
        m.checkNotNullParameter(context, "context");
        String string = context.getString(2131895325);
        m.checkNotNullExpressionValue(string, "context.getString(R.string.search_filter_from)");
        this.fromFilterString = string;
        String string2 = context.getString(2131895327);
        m.checkNotNullExpressionValue(string2, "context.getString(R.string.search_filter_in)");
        this.inFilterString = string2;
        String string3 = context.getString(2131895329);
        m.checkNotNullExpressionValue(string3, "context.getString(R.string.search_filter_mentions)");
        this.mentionsFilterString = string3;
        String string4 = context.getString(2131895326);
        m.checkNotNullExpressionValue(string4, "context.getString(R.string.search_filter_has)");
        this.hasFilterString = string4;
        String string5 = context.getString(2131895303);
        m.checkNotNullExpressionValue(string5, "context.getString(R.string.search_answer_has_link)");
        this.linkAnswerString = string5;
        String string6 = context.getString(2131895301);
        m.checkNotNullExpressionValue(string6, "context.getString(R.stri….search_answer_has_embed)");
        this.embedAnswerString = string6;
        String string7 = context.getString(2131895300);
        m.checkNotNullExpressionValue(string7, "context.getString(R.stri…ch_answer_has_attachment)");
        this.fileAnswerString = string7;
        String string8 = context.getString(2131895306);
        m.checkNotNullExpressionValue(string8, "context.getString(R.stri….search_answer_has_video)");
        this.videoAnswerString = string8;
        String string9 = context.getString(2131895302);
        m.checkNotNullExpressionValue(string9, "context.getString(R.stri….search_answer_has_image)");
        this.imageAnswerString = string9;
        String string10 = context.getString(2131895304);
        m.checkNotNullExpressionValue(string10, "context.getString(R.stri….search_answer_has_sound)");
        this.soundAnswerString = string10;
        String string11 = context.getString(2131895305);
        m.checkNotNullExpressionValue(string11, "context.getString(R.stri…earch_answer_has_sticker)");
        this.stickerAnswerString = string11;
    }

    @Override // com.discord.utilities.search.strings.SearchStringProvider
    public String getEmbedAnswerString() {
        return this.embedAnswerString;
    }

    @Override // com.discord.utilities.search.strings.SearchStringProvider
    public String getFileAnswerString() {
        return this.fileAnswerString;
    }

    @Override // com.discord.utilities.search.strings.SearchStringProvider
    public String getFromFilterString() {
        return this.fromFilterString;
    }

    @Override // com.discord.utilities.search.strings.SearchStringProvider
    public String getHasFilterString() {
        return this.hasFilterString;
    }

    @Override // com.discord.utilities.search.strings.SearchStringProvider
    public String getImageAnswerString() {
        return this.imageAnswerString;
    }

    @Override // com.discord.utilities.search.strings.SearchStringProvider
    public String getInFilterString() {
        return this.inFilterString;
    }

    @Override // com.discord.utilities.search.strings.SearchStringProvider
    public String getLinkAnswerString() {
        return this.linkAnswerString;
    }

    @Override // com.discord.utilities.search.strings.SearchStringProvider
    public String getMentionsFilterString() {
        return this.mentionsFilterString;
    }

    @Override // com.discord.utilities.search.strings.SearchStringProvider
    public String getSoundAnswerString() {
        return this.soundAnswerString;
    }

    @Override // com.discord.utilities.search.strings.SearchStringProvider
    public String getStickerAnswerString() {
        return this.stickerAnswerString;
    }

    @Override // com.discord.utilities.search.strings.SearchStringProvider
    public String getVideoAnswerString() {
        return this.videoAnswerString;
    }
}
