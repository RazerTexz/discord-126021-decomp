package com.discord.utilities.search.strings;

import android.content.Context;
import com.discord.R;
import d0.z.d.Intrinsics3;

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
        Intrinsics3.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.search_filter_from);
        Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.string.search_filter_from)");
        this.fromFilterString = string;
        String string2 = context.getString(R.string.search_filter_in);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.string.search_filter_in)");
        this.inFilterString = string2;
        String string3 = context.getString(R.string.search_filter_mentions);
        Intrinsics3.checkNotNullExpressionValue(string3, "context.getString(R.string.search_filter_mentions)");
        this.mentionsFilterString = string3;
        String string4 = context.getString(R.string.search_filter_has);
        Intrinsics3.checkNotNullExpressionValue(string4, "context.getString(R.string.search_filter_has)");
        this.hasFilterString = string4;
        String string5 = context.getString(R.string.search_answer_has_link);
        Intrinsics3.checkNotNullExpressionValue(string5, "context.getString(R.string.search_answer_has_link)");
        this.linkAnswerString = string5;
        String string6 = context.getString(R.string.search_answer_has_embed);
        Intrinsics3.checkNotNullExpressionValue(string6, "context.getString(R.stri….search_answer_has_embed)");
        this.embedAnswerString = string6;
        String string7 = context.getString(R.string.search_answer_has_attachment);
        Intrinsics3.checkNotNullExpressionValue(string7, "context.getString(R.stri…ch_answer_has_attachment)");
        this.fileAnswerString = string7;
        String string8 = context.getString(R.string.search_answer_has_video);
        Intrinsics3.checkNotNullExpressionValue(string8, "context.getString(R.stri….search_answer_has_video)");
        this.videoAnswerString = string8;
        String string9 = context.getString(R.string.search_answer_has_image);
        Intrinsics3.checkNotNullExpressionValue(string9, "context.getString(R.stri….search_answer_has_image)");
        this.imageAnswerString = string9;
        String string10 = context.getString(R.string.search_answer_has_sound);
        Intrinsics3.checkNotNullExpressionValue(string10, "context.getString(R.stri….search_answer_has_sound)");
        this.soundAnswerString = string10;
        String string11 = context.getString(R.string.search_answer_has_sticker);
        Intrinsics3.checkNotNullExpressionValue(string11, "context.getString(R.stri…earch_answer_has_sticker)");
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
