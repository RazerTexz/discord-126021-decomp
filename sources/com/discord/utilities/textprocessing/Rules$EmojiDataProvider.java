package com.discord.utilities.textprocessing;

import com.discord.models.domain.emoji.ModelEmojiUnicode;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: Rules.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface Rules$EmojiDataProvider {
    Map<String, ModelEmojiUnicode> getUnicodeEmojiSurrogateMap();

    Map<String, ModelEmojiUnicode> getUnicodeEmojisNamesMap();

    Pattern getUnicodeEmojisPattern();
}
