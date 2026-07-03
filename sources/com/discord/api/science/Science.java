package com.discord.api.science;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Science.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Science {
    private final List<Event> events;
    private final String token;

    /* JADX INFO: compiled from: Science.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: Science.kt */
        public static final /* data */ class MapObject extends Event {
            private final Map<String, Object> properties;
            private final String type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MapObject(String str, Map<String, ? extends Object> map) {
                super(null);
                C12238m.checkNotNullParameter(str, "type");
                C12238m.checkNotNullParameter(map, "properties");
                this.type = str;
                this.properties = map;
            }

            @Override // com.discord.api.science.Science.Event
            /* JADX INFO: renamed from: a, reason: from getter */
            public String getType() {
                return this.type;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MapObject)) {
                    return false;
                }
                MapObject mapObject = (MapObject) other;
                return C12238m.areEqual(this.type, mapObject.type) && C12238m.areEqual(this.properties, mapObject.properties);
            }

            public int hashCode() {
                String str = this.type;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                Map<String, Object> map = this.properties;
                return iHashCode + (map != null ? map.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("MapObject(type=");
                sbM833U.append(this.type);
                sbM833U.append(", properties=");
                return C1643a.m825M(sbM833U, this.properties, ")");
            }
        }

        /* JADX INFO: compiled from: Science.kt */
        public static final /* data */ class SchemaObject extends Event {
            private final AnalyticsSchema schema;
            private final String type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SchemaObject(AnalyticsSchema analyticsSchema) {
                super(null);
                C12238m.checkNotNullParameter(analyticsSchema, "schema");
                this.schema = analyticsSchema;
                this.type = analyticsSchema.getAnalyticsSchemaTypeName();
            }

            @Override // com.discord.api.science.Science.Event
            /* JADX INFO: renamed from: a, reason: from getter */
            public String getType() {
                return this.type;
            }

            /* JADX INFO: renamed from: b, reason: from getter */
            public final AnalyticsSchema getSchema() {
                return this.schema;
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SchemaObject) && C12238m.areEqual(this.schema, ((SchemaObject) other).schema);
                }
                return true;
            }

            public int hashCode() {
                AnalyticsSchema analyticsSchema = this.schema;
                if (analyticsSchema != null) {
                    return analyticsSchema.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("SchemaObject(schema=");
                sbM833U.append(this.schema);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        public Event() {
        }

        /* JADX INFO: renamed from: a */
        public abstract String getType();

        public Event(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Science(String str, List<? extends Event> list) {
        this.token = str;
        this.events = list;
    }
}
