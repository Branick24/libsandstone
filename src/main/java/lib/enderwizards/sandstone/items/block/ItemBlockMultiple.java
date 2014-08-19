package lib.enderwizards.sandstone.items.block;

import java.util.List;

import lib.enderwizards.sandstone.blocks.BlockMultiple;
import lib.enderwizards.sandstone.blocks.SubBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMultiple extends ItemBlockBase {

	public ItemBlockMultiple(Block block) {
		super(block);
		this.hasSubtypes = true;
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean whatDoesThisEvenDo) {
        SubBlock[] blocks = ((BlockMultiple) this.field_150939_a).blocks;
    	if(stack.getItemDamage() < blocks.length) {
        	blocks[stack.getItemDamage()].addInformation(stack, player, list);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getItemStackDisplayName(ItemStack stack) {
        SubBlock[] blocks = ((BlockMultiple) this.field_150939_a).blocks;
        if(stack.getItemDamage() < blocks.length) {
        	blocks[stack.getItemDamage()].getItemStackDisplayName(stack);
        }
        return "null";
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tabs, List list)  {
		for(int index = 0; index < ((BlockMultiple) this.field_150939_a).getLength(); index++) {
			list.add(new ItemStack(item, 1, index));
		}
	}

}