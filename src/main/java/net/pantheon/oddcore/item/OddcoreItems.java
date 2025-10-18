package net.pantheon.oddcore.item;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pantheon.oddcore.Oddcore;
import net.pantheon.oddcore.block.OddcoreBlocks;

public class OddcoreItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Oddcore.MODID);

    public static final DeferredItem<Item> GUNMETAL = ITEMS.register("gunmetal_ingot",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(OddcoreItems.GUNMETAL);
        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(OddcoreBlocks.GUNMETAL_BLOCK);

        }
    }
}
