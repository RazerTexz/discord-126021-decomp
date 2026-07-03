package com.discord.widgets.chat.input.autocomplete;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.autocomplete.sources.ApplicationCommandsAutocompletableSource;
import com.discord.widgets.chat.input.autocomplete.sources.ChannelAutocompletableSource;
import com.discord.widgets.chat.input.autocomplete.sources.EmojiAutocompletableSource;
import com.discord.widgets.chat.input.autocomplete.sources.UserAutocompletableSource;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Lazy;
import p507d0.C12083g;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.functions.Func4;

/* JADX INFO: compiled from: InputAutocompletables.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputAutocompletables {
    public static final ChatInputAutocompletables INSTANCE = new ChatInputAutocompletables();

    /* JADX INFO: renamed from: EMOJI_SOURCE$delegate, reason: from kotlin metadata */
    private static final Lazy EMOJI_SOURCE = C12083g.lazy(ChatInputAutocompletables$EMOJI_SOURCE$2.INSTANCE);

    /* JADX INFO: renamed from: CHANNEL_SOURCE$delegate, reason: from kotlin metadata */
    private static final Lazy CHANNEL_SOURCE = C12083g.lazy(ChatInputAutocompletables$CHANNEL_SOURCE$2.INSTANCE);

    /* JADX INFO: renamed from: USERS_SOURCE$delegate, reason: from kotlin metadata */
    private static final Lazy USERS_SOURCE = C12083g.lazy(ChatInputAutocompletables$USERS_SOURCE$2.INSTANCE);

    /* JADX INFO: renamed from: APPLICATION_COMMANDS_SOURCE$delegate, reason: from kotlin metadata */
    private static final Lazy APPLICATION_COMMANDS_SOURCE = C12083g.lazy(ChatInputAutocompletables$APPLICATION_COMMANDS_SOURCE$2.INSTANCE);

    private ChatInputAutocompletables() {
    }

    public final ApplicationCommandsAutocompletableSource getAPPLICATION_COMMANDS_SOURCE() {
        return (ApplicationCommandsAutocompletableSource) APPLICATION_COMMANDS_SOURCE.getValue();
    }

    public final ChannelAutocompletableSource getCHANNEL_SOURCE() {
        return (ChannelAutocompletableSource) CHANNEL_SOURCE.getValue();
    }

    public final EmojiAutocompletableSource getEMOJI_SOURCE() {
        return (EmojiAutocompletableSource) EMOJI_SOURCE.getValue();
    }

    public final UserAutocompletableSource getUSERS_SOURCE() {
        return (UserAutocompletableSource) USERS_SOURCE.getValue();
    }

    public final Observable<Map<LeadingIdentifier, Set<Autocompletable>>> observeChannelAutocompletables(long channelId) {
        Observable<R> observableM11083G = StoreStream.INSTANCE.getChannels().observeChannel(channelId).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
        C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
        Observable observableM11099Y = observableM11083G.m11099Y(new InterfaceC12589b<Channel, Observable<? extends Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>>>>() { // from class: com.discord.widgets.chat.input.autocomplete.ChatInputAutocompletables.observeChannelAutocompletables.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends Map<LeadingIdentifier, Set<Autocompletable>>> call(Channel channel) {
                ChatInputAutocompletables chatInputAutocompletables = ChatInputAutocompletables.INSTANCE;
                ApplicationCommandsAutocompletableSource application_commands_source = chatInputAutocompletables.getAPPLICATION_COMMANDS_SOURCE();
                C12238m.checkNotNullExpressionValue(channel, "channel");
                return Observable.m11073h(application_commands_source.observeApplicationCommandAutocompletables(channel), chatInputAutocompletables.getEMOJI_SOURCE().observeEmojiAutocompletables(channel), chatInputAutocompletables.getCHANNEL_SOURCE().observeChannelAutocompletables(channel.getGuildId()), chatInputAutocompletables.getUSERS_SOURCE().observeUserAutocompletables(channel), new Func4<Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>>>() { // from class: com.discord.widgets.chat.input.autocomplete.ChatInputAutocompletables.observeChannelAutocompletables.1.1
                    @Override // p658rx.functions.Func4
                    public final Map<LeadingIdentifier, Set<Autocompletable>> call(Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map2, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map3, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map4) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        C12238m.checkNotNullExpressionValue(map, "commands");
                        InputAutocompletablesKt.merge(linkedHashMap, map);
                        C12238m.checkNotNullExpressionValue(map2, "emojis");
                        InputAutocompletablesKt.merge(linkedHashMap, map2);
                        C12238m.checkNotNullExpressionValue(map3, "channels");
                        InputAutocompletablesKt.merge(linkedHashMap, map3);
                        C12238m.checkNotNullExpressionValue(map4, "users");
                        InputAutocompletablesKt.merge(linkedHashMap, map4);
                        return linkedHashMap;
                    }
                });
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream.getChannels(…e>>\n          }\n        }");
        return ObservableExtensionsKt.computationLatest(observableM11099Y);
    }
}
