package com.discord.widgets.chat.input.models;

import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: TagObject.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface TagObject extends MGRecyclerDataPayload {
    String getDisplayTag();

    String getTag();

    Pattern getTagRegex();
}
