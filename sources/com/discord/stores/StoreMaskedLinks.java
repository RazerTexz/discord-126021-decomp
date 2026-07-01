package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import androidx.annotation.VisibleForTesting;
import com.discord.BuildConfig;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.user.User;
import d0.t.Collections2;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;

/* JADX INFO: compiled from: StoreMaskedLinks.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMaskedLinks extends StoreV2 {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final Regex DISCORD_DOMAINS_REGEX;
    private static final String HOST_SPOTIFY = "https://spotify.com";
    private static final String HOST_SPOTIFY_OPEN = "https://open.spotify.com";
    private static final List<String> TRUSTED_DOMAINS;
    private static final String USER_TRUSTED_DOMAINS_CACHE_KEY = "USER_TRUSTED_DOMAINS_CACHE_KEY";
    private final Dispatcher dispatcher;
    private final StoreChannelsSelected storeChannelsSelected;
    private final StoreUserRelationships storeUserRelationships;
    private Set<String> userTrustedDomains;
    private Set<String> userTrustedDomainsSnapshot;

    /* JADX INFO: compiled from: StoreMaskedLinks.kt */
    public static final class Companion {
        private Companion() {
        }

        private final String getDomainName(String url) {
            try {
                Uri uri = Uri.parse(url);
                Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(url)");
                return uri.getHost();
            } catch (Exception unused) {
                return null;
            }
        }

        @VisibleForTesting
        public final boolean isImplicitlyTrustedDomain$app_productionGoogleRelease(String name) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return StoreMaskedLinks.TRUSTED_DOMAINS.contains(name) || StoreMaskedLinks.DISCORD_DOMAINS_REGEX.containsMatchIn(name);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMaskedLinks$trustDomain$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMaskedLinks.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$url = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            String domainName = StoreMaskedLinks.INSTANCE.getDomainName(this.$url);
            if (domainName != null) {
                StoreMaskedLinks.this.userTrustedDomains.add(domainName);
                StoreMaskedLinks.this.markChanged();
            }
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        TRUSTED_DOMAINS = Collections2.listOfNotNull((Object[]) new String[]{companion.getDomainName(BuildConfig.HOST), companion.getDomainName(BuildConfig.HOST_ALTERNATE), companion.getDomainName(BuildConfig.HOST_CDN), companion.getDomainName(BuildConfig.HOST_GIFT), companion.getDomainName(BuildConfig.HOST_INVITE), companion.getDomainName(BuildConfig.HOST_GUILD_TEMPLATE), companion.getDomainName(HOST_SPOTIFY), companion.getDomainName(HOST_SPOTIFY_OPEN)});
        DISCORD_DOMAINS_REGEX = new Regex("(?:^|\\.)(?:discordapp|discord)\\.com$");
    }

    public StoreMaskedLinks(Dispatcher dispatcher, StoreChannelsSelected storeChannelsSelected, StoreUserRelationships storeUserRelationships) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        Intrinsics3.checkNotNullParameter(storeUserRelationships, "storeUserRelationships");
        this.dispatcher = dispatcher;
        this.storeChannelsSelected = storeChannelsSelected;
        this.storeUserRelationships = storeUserRelationships;
        this.userTrustedDomainsSnapshot = Sets5.emptySet();
        this.userTrustedDomains = new LinkedHashSet();
    }

    public final Set<String> getUserTrustedDomains() {
        return this.userTrustedDomainsSnapshot;
    }

    @Override // com.discord.stores.Store
    @Store3
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        Set<String> stringSet = getPrefs().getStringSet(USER_TRUSTED_DOMAINS_CACHE_KEY, Sets5.emptySet());
        if (stringSet == null) {
            stringSet = new LinkedHashSet<>();
        }
        this.userTrustedDomains = new HashSet(stringSet);
        markChanged();
    }

    public final boolean isTrustedDomain(String url, String mask) {
        Intrinsics3.checkNotNullParameter(url, "url");
        if (isTrustedDomain(url)) {
            return true;
        }
        boolean z2 = mask == null || Intrinsics3.areEqual(mask, url);
        Channel selectedChannel = this.storeChannelsSelected.getSelectedChannel();
        User userA = selectedChannel != null ? ChannelUtils.a(selectedChannel) : null;
        if (ModelUserRelationship.isType(this.storeUserRelationships.getRelationships().get(userA != null ? Long.valueOf(userA.getId()) : null), 1)) {
            return z2;
        }
        return false;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        this.userTrustedDomainsSnapshot = new HashSet(this.userTrustedDomains);
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putStringSet(USER_TRUSTED_DOMAINS_CACHE_KEY, this.userTrustedDomainsSnapshot);
        editorEdit.apply();
    }

    public final void trustDomain(String url) {
        Intrinsics3.checkNotNullParameter(url, "url");
        this.dispatcher.schedule(new AnonymousClass1(url));
    }

    private final boolean isTrustedDomain(String url) {
        Companion companion = INSTANCE;
        String domainName = companion.getDomainName(url);
        return _Collections.contains(this.userTrustedDomainsSnapshot, domainName) || (domainName != null && companion.isImplicitlyTrustedDomain$app_productionGoogleRelease(domainName));
    }
}
