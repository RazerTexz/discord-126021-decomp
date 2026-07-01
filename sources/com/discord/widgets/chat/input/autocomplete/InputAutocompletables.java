package com.discord.widgets.chat.input.autocomplete;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.autocomplete.sources.ApplicationCommandsAutocompletableSource;
import com.discord.widgets.chat.input.autocomplete.sources.ChannelAutocompletableSource;
import com.discord.widgets.chat.input.autocomplete.sources.EmojiAutocompletableSource;
import com.discord.widgets.chat.input.autocomplete.sources.UserMentionableSource;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Lazy;
import rx.Observable;
import rx.functions.Func4;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.ChatInputAutocompletables, reason: use source file name */
/* JADX INFO: compiled from: InputAutocompletables.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InputAutocompletables {
    public static final InputAutocompletables INSTANCE = new InputAutocompletables();

    /* JADX INFO: renamed from: EMOJI_SOURCE$delegate, reason: from kotlin metadata */
    private static final Lazy EMOJI_SOURCE = LazyJVM.lazy(InputAutocompletables4.INSTANCE);

    /* JADX INFO: renamed from: CHANNEL_SOURCE$delegate, reason: from kotlin metadata */
    private static final Lazy CHANNEL_SOURCE = LazyJVM.lazy(InputAutocompletables3.INSTANCE);

    /* JADX INFO: renamed from: USERS_SOURCE$delegate, reason: from kotlin metadata */
    private static final Lazy USERS_SOURCE = LazyJVM.lazy(InputAutocompletables5.INSTANCE);

    /* JADX INFO: renamed from: APPLICATION_COMMANDS_SOURCE$delegate, reason: from kotlin metadata */
    private static final Lazy APPLICATION_COMMANDS_SOURCE = LazyJVM.lazy(InputAutocompletables2.INSTANCE);

    private InputAutocompletables() {
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

    public final UserMentionableSource getUSERS_SOURCE() {
        return (UserMentionableSource) USERS_SOURCE.getValue();
    }

    public final Observable<Map<LeadingIdentifier, Set<Autocompletable>>> observeChannelAutocompletables(long channelId) {
        Observable<R> observableG = StoreStream.INSTANCE.getChannels().observeChannel(channelId).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableY = observableG.Y(new Func1<Channel, Observable<? extends Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>>>>() { // from class: com.discord.widgets.chat.input.autocomplete.ChatInputAutocompletables.observeChannelAutocompletables.1
            @Override // j0.k.Func1
            public final Observable<? extends Map<LeadingIdentifier, Set<Autocompletable>>> call(Channel channel) {
                InputAutocompletables inputAutocompletables = InputAutocompletables.INSTANCE;
                ApplicationCommandsAutocompletableSource application_commands_source = inputAutocompletables.getAPPLICATION_COMMANDS_SOURCE();
                Intrinsics3.checkNotNullExpressionValue(channel, "channel");
                return Observable.h(application_commands_source.observeApplicationCommandAutocompletables(channel), inputAutocompletables.getEMOJI_SOURCE().observeEmojiAutocompletables(channel), inputAutocompletables.getCHANNEL_SOURCE().observeChannelAutocompletables(channel.getGuildId()), inputAutocompletables.getUSERS_SOURCE().observeUserAutocompletables(channel), new Func4<Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>>>() { // from class: com.discord.widgets.chat.input.autocomplete.ChatInputAutocompletables.observeChannelAutocompletables.1.1
                    @Override // rx.functions.Func4
                    public final Map<LeadingIdentifier, Set<Autocompletable>> call(Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map2, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map3, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map4) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        Intrinsics3.checkNotNullExpressionValue(map, "commands");
                        InputAutocompletables6.merge(linkedHashMap, map);
                        Intrinsics3.checkNotNullExpressionValue(map2, "emojis");
                        InputAutocompletables6.merge(linkedHashMap, map2);
                        Intrinsics3.checkNotNullExpressionValue(map3, "channels");
                        InputAutocompletables6.merge(linkedHashMap, map3);
                        Intrinsics3.checkNotNullExpressionValue(map4, "users");
                        InputAutocompletables6.merge(linkedHashMap, map4);
                        return linkedHashMap;
                    }
                });
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream.getChannels(…e>>\n          }\n        }");
        return ObservableExtensionsKt.computationLatest(observableY);
    }
}
