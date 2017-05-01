package mod.model.objects.items;

import java.util.ArrayList;

import mod.controller.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MistbornItems
{
	public static MistbornItem copper_ingot;
	public static MistbornItem tin_ingot;
	public static MistbornItem zinc_ingot;
	public static MistbornItem steel_ingot;
	public static MistbornItem pewter_ingot;
	public static MistbornItem bronze_ingot;
	public static MistbornItem brass_ingot;
	public static MistbornItem atium_bead;
	public static MistbornItem Shaving_Knife;
	public static MistbornItem copper_shavings;
	public static MistbornItem tin_shavings;
	public static MistbornItem zinc_shavings;
	public static MistbornItem steel_shavings;
	public static MistbornItem pewter_shavings;
	public static MistbornItem bronze_shavings;
	public static MistbornItem brass_shavings;
	public static MistbornItem iron_shavings;
	public static MistbornItem gold_shavings;
	public static MistbornItem vial;
	public static MistbornItem medvial;
	public static MistbornItem hugevial;
	public static MistbornItem lerasium;
	public static MistbornItem ls;
	public static MistbornItem lz;
	public static MistbornItem lp;
	public static MistbornItem lc;
	public static MistbornItem li;
	public static MistbornItem lbro;
	public static MistbornItem lt;
	public static MistbornItem lbra;
	public static MistbornItem lg;
	public static MistbornItem la;
	public static ItemSword glassSword;
	public static ItemSword steelSword;
	public static ItemPickaxe steelPick;
	public static MistbornAxe steelAxe;
	public static ItemSpade steelShovel;
	public static ItemHoe steelHoe;
	public static ItemSword tinSword;
	public static ItemPickaxe tinPick;
	public static MistbornAxe tinAxe;
	public static ItemSpade tinShovel;
	public static ItemHoe tinHoe;
	public static ItemSword zincSword;
	public static ItemPickaxe zincPick;
	public static MistbornAxe zincAxe;
	public static ItemSpade zincShovel;
	public static ItemHoe zincHoe;
	public static ItemSword copperSword;
	public static ItemPickaxe copperPick;
	public static MistbornAxe copperAxe;
	public static ItemSpade copperShovel;
	public static ItemHoe copperHoe;
	public static ItemSword obsidianSword;
	public static ItemArmor steelHelm;
	public static ItemArmor steelPants;
	public static ItemArmor steelShirt;
	public static ItemArmor steelShoes;
	public static ItemArmor pewterHelm;
	public static ItemArmor pewterPants;
	public static ItemArmor pewterShirt;
	public static ItemArmor pewterShoes;
	public static ItemArmor bronzeHelm;
	public static ItemArmor bronzePants;
	public static ItemArmor bronzeShirt;
	public static ItemArmor bronzeShoes;
	public static ItemArmor brassHelm;
	public static ItemArmor brassPants;
	public static ItemArmor brassShirt;
	public static ItemArmor brassShoes;
	public static ToolMaterial Glass = EnumHelper.addToolMaterial("Glass", 2, 15, 20.0F, 4.0F, 4);
	public static ToolMaterial Obsidian = EnumHelper.addToolMaterial("Obsidian", 3, 3000, 20.0F, 2.5F, 5);
	public static ToolMaterial Steel = EnumHelper.addToolMaterial("Steel", 2, 500, 5.5f, 1.5f, 14);
	public static ToolMaterial Tin = EnumHelper.addToolMaterial("Tin", 2, 150, 7f, 2.5f, 14);
	public static ToolMaterial Zinc = EnumHelper.addToolMaterial("Zinc", 2, 275, 6.5f, 2.2f, 0);
	public static ToolMaterial Copper = EnumHelper.addToolMaterial("Copper", 2, 200, 5.5f, 1.5f, 70);
	public static ArmorMaterial SteelA = EnumHelper.addArmorMaterial("SteelA", Reference.ID + ":steelArmor", 16, new int[] { 2, 6, 5, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0f);
	public static ArmorMaterial PewterA = EnumHelper.addArmorMaterial("PewterA", Reference.ID + ":pewterArmor", 10, new int[] { 3, 7, 6, 3 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0f);
	public static ArmorMaterial BronzeA = EnumHelper.addArmorMaterial("BronzeA", Reference.ID + ":bronzeArmor", 12, new int[] { 1, 5, 4, 1 }, 90, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0f);
	public static ArmorMaterial BrassA = EnumHelper.addArmorMaterial("BrassA", Reference.ID + ":brassArmor", 15, new int[] { 3, 7, 6, 3 }, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0f);

	public static void initItems()
	{

		ArrayList<MistbornItem> toRegister = new ArrayList<MistbornItem>();
		copper_ingot = new MistbornItem("copper_ingot", 10);
		toRegister.add(copper_ingot);
		tin_ingot = new MistbornItem("tin_ingot", 10);
		toRegister.add(tin_ingot);
		zinc_ingot = new MistbornItem("zinc_ingot", 10);
		toRegister.add(zinc_ingot);
		steel_ingot = new MistbornItem("steel_ingot", 10);
		toRegister.add(steel_ingot);
		pewter_ingot = new MistbornItem("pewter_ingot", 10);
		toRegister.add(pewter_ingot);
		bronze_ingot = new MistbornItem("bronze_ingot", 10);
		toRegister.add(bronze_ingot);
		brass_ingot = new MistbornItem("brass_ingot", 10);
		toRegister.add(brass_ingot);
		copper_shavings = new MistbornShaving("copper_shavings", 10);
		toRegister.add(copper_shavings);
		tin_shavings = new MistbornShaving("tin_shavings", 10);
		toRegister.add(tin_shavings);
		zinc_shavings = new MistbornShaving("zinc_shavings", 10);
		toRegister.add(zinc_shavings);
		steel_shavings = new MistbornShaving("steel_shavings", 10);
		toRegister.add(steel_shavings);
		pewter_shavings = new MistbornShaving("pewter_shavings", 10);
		toRegister.add(pewter_shavings);
		bronze_shavings = new MistbornShaving("bronze_shavings", 10);
		toRegister.add(bronze_shavings);
		brass_shavings = new MistbornShaving("brass_shavings", 10);
		toRegister.add(brass_shavings);
		gold_shavings = new MistbornShaving("gold_shavings", 10);
		toRegister.add(gold_shavings);
		iron_shavings = new MistbornShaving("iron_shavings", 10);
		toRegister.add(iron_shavings);
		atium_bead = new MistbornShaving("atium_bead", 10);
		toRegister.add(atium_bead);
		Shaving_Knife = new ShavingKnife("shaving_knife", 10);
		toRegister.add(Shaving_Knife);
		vial = new MistbornVial("vial", 10, 0);
		toRegister.add(vial);
		medvial = new MistbornVial("vialmed", 10, 1);
		toRegister.add(medvial);
		hugevial = new MistbornVial("vialhuge", 10, 2);
		toRegister.add(hugevial);
		lerasium = new Lerasium("lerasium", 10, 11);
		toRegister.add(lerasium);
		ls = new Lerasium("ls", 10, 1);
		toRegister.add(ls);
		lz = new Lerasium("lz", 10, 2);
		toRegister.add(lz);
		lp = new Lerasium("lp", 10, 3);
		toRegister.add(lp);
		lc = new Lerasium("lc", 10, 4);
		toRegister.add(lc);
		li = new Lerasium("li", 10, 5);
		toRegister.add(li);
		lbro = new Lerasium("lbro", 10, 6);
		toRegister.add(lbro);
		lt = new Lerasium("lt", 10, 7);
		toRegister.add(lt);
		lbra = new Lerasium("lbra", 10, 8);
		toRegister.add(lbra);
		lg = new Lerasium("lg", 10, 9);
		toRegister.add(lg);
		la = new Lerasium("la", 10, 10);
		toRegister.add(la);
		if (FMLCommonHandler.instance().getSide().isClient())
		{
			for (int index = 0; index < toRegister.size(); index++)
			{
				Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(toRegister.get(index), 0, new ModelResourceLocation(toRegister.get(index).getRegistryName(), "inventory"));
			}
		}
		for (MistbornItem item : toRegister)
		{
			GameRegistry.register(item);
		}
		ArrayList<Item> toolRegister = new ArrayList<Item>();
		glassSword = new MistbornSword("glasssword", 10, Glass);
		toolRegister.add(glassSword);
		steelSword = new MistbornSword("steelsword", 10, Steel);
		toolRegister.add(steelSword);
		steelPick = new MistbornPickaxe("steelpick", 10, Steel);
		toolRegister.add(steelPick);
		steelAxe = new MistbornAxe("steelaxe", 10, Steel);
		toolRegister.add(steelAxe);
		steelShovel = new MistbornSpade("steelshovel", 10, Steel);
		toolRegister.add(steelShovel);
		steelHoe = new MistbornHoe("steelhoe", 10, Steel);
		toolRegister.add(steelHoe);
		tinSword = new MistbornSword("tinsword", 10, Tin);
		toolRegister.add(tinSword);
		tinPick = new MistbornPickaxe("tinpick", 10, Tin);
		toolRegister.add(tinPick);
		tinAxe = new MistbornAxe("tinaxe", 10, Tin);
		toolRegister.add(tinAxe);
		tinShovel = new MistbornSpade("tinshovel", 10, Tin);
		toolRegister.add(tinShovel);
		tinHoe = new MistbornHoe("tinhoe", 10, Tin);
		toolRegister.add(tinHoe);
		zincSword = new MistbornSword("zincsword", 10, Zinc);
		toolRegister.add(zincSword);
		zincPick = new MistbornPickaxe("zincpick", 10, Zinc);
		toolRegister.add(zincPick);
		zincAxe = new MistbornAxe("zincaxe", 10, Zinc);
		toolRegister.add(zincAxe);
		zincShovel = new MistbornSpade("zincshovel", 10, Zinc);
		toolRegister.add(zincShovel);
		zincHoe = new MistbornHoe("zinchoe", 10, Zinc);
		toolRegister.add(zincHoe);
		copperSword = new MistbornSword("coppersword", 10, Copper);
		toolRegister.add(copperSword);
		copperPick = new MistbornPickaxe("copperpick", 10, Copper);
		toolRegister.add(copperPick);
		copperAxe = new MistbornAxe("copperaxe", 10, Copper);
		toolRegister.add(copperAxe);
		copperShovel = new MistbornSpade("coppershovel", 10, Copper);
		toolRegister.add(copperShovel);
		copperHoe = new MistbornHoe("copperhoe", 10, Copper);
		toolRegister.add(copperHoe);
		obsidianSword = new MistbornSword("obsidiansword", 10, Obsidian);
		toolRegister.add(obsidianSword);

		steelHelm = new MistbornArmor("steelhelm", 10, SteelA, EntityEquipmentSlot.HEAD, 1);
		toolRegister.add(steelHelm);
		steelShirt = new MistbornArmor("steelshirt", 10, SteelA, EntityEquipmentSlot.CHEST, 1);
		toolRegister.add(steelShirt);
		steelPants = new MistbornArmor("steelpants", 10, SteelA, EntityEquipmentSlot.LEGS, 2);
		toolRegister.add(steelPants);
		steelShoes = new MistbornArmor("steelshoes", 10, SteelA, EntityEquipmentSlot.FEET, 1);
		toolRegister.add(steelShoes);

		pewterHelm = new MistbornArmor("pewterhelm", 10, PewterA, EntityEquipmentSlot.HEAD, 1);
		toolRegister.add(pewterHelm);
		pewterShirt = new MistbornArmor("pewtershirt", 10, PewterA, EntityEquipmentSlot.CHEST, 1);
		toolRegister.add(pewterShirt);
		pewterPants = new MistbornArmor("pewterpants", 10, PewterA, EntityEquipmentSlot.LEGS, 2);
		toolRegister.add(pewterPants);
		pewterShoes = new MistbornArmor("pewtershoes", 10, PewterA, EntityEquipmentSlot.FEET, 1);
		toolRegister.add(pewterShoes);
		
		bronzeHelm = new MistbornArmor("bronzehelm", 10, BronzeA, EntityEquipmentSlot.HEAD, 1);
		toolRegister.add(bronzeHelm);
		bronzeShirt = new MistbornArmor("bronzeshirt", 10, BronzeA, EntityEquipmentSlot.CHEST, 1);
		toolRegister.add(bronzeShirt);
		bronzePants = new MistbornArmor("bronzepants", 10, BronzeA, EntityEquipmentSlot.LEGS, 2);
		toolRegister.add(bronzePants);
		bronzeShoes = new MistbornArmor("bronzeshoes", 10, BronzeA, EntityEquipmentSlot.FEET, 1);
		toolRegister.add(bronzeShoes);
		
		brassHelm = new MistbornArmor("brasshelm", 10, BrassA, EntityEquipmentSlot.HEAD, 1);
		toolRegister.add(brassHelm);
		brassShirt = new MistbornArmor("brassshirt", 10, BrassA, EntityEquipmentSlot.CHEST, 1);
		toolRegister.add(brassShirt);
		brassPants = new MistbornArmor("brasspants", 10, BrassA, EntityEquipmentSlot.LEGS, 2);
		toolRegister.add(brassPants);
		brassShoes = new MistbornArmor("brassshoes", 10, BrassA, EntityEquipmentSlot.FEET, 1);
		toolRegister.add(brassShoes);

		if (FMLCommonHandler.instance().getSide().isClient())
		{
			for (int index = 0; index < toolRegister.size(); index++)
			{
				Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(toolRegister.get(index), 0, new ModelResourceLocation(toolRegister.get(index).getRegistryName(), "inventory"));
			}
		}
		for (Item item : toolRegister)
		{
			GameRegistry.register(item);
		}
	}

}
