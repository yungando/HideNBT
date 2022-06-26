package net.yungando.hidenbt.tooltip;

import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.text.*;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;

public class TooltipChanger
{
    public ArrayList<Text> Main(MinecraftClient client, ItemStack itemStack, ArrayList<Text> list)
    {
        ArrayList<Text> id = new ArrayList<Text>();
        final Identifier nameForObject = Registry.ITEM.getId(itemStack.getItem());
        id.add(new LiteralText(nameForObject.toString()).formatted(Formatting.DARK_GRAY));
        int idIndex = list.indexOf(id.get(0));
        list.remove(idIndex);

        if (itemStack.hasNbt())
        {
            ArrayList<Text> nbt = new ArrayList<Text>();
            nbt.add((new TranslatableText("item.nbt_tags", itemStack.getNbt().getKeys().size())).formatted(Formatting.DARK_GRAY));
            int nbtIndex = list.indexOf(nbt.get(0));
            list.remove(nbtIndex);
        }

        return list;
    }
}