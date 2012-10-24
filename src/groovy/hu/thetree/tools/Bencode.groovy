package hu.thetree.tools

import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 *
 * @author geoff
 */
class Bencode {

	static decode( String bString ) {
		List reverse_chars = bString.toList().reverse();
		def root = parse( reverse_chars );
		return root;
	}

	static protected parse( List reverse_chars ) {
		def lastChar = reverse_chars.pop();

		if ( lastChar == 'd' ) {
			lastChar = reverse_chars.pop();
			Map map = [:];
			while( lastChar != 'e' ) {
				//undo the pop so we can parse the contents
				reverse_chars.push( lastChar );
				String key = parse( reverse_chars );
				map[key] = parse( reverse_chars )

				lastChar = reverse_chars.pop();
			}
			return map;
		}
		else if ( lastChar == 'l' ) {
			lastChar = reverse_chars.pop()
			List list = [];
			while ( lastChar != 'e') {
				reverse_chars.push( lastChar );
				list.push( parse( reverse_chars ) );
				lastChar = reverse_chars.pop();
			}
			return list;
		}
		else if ( lastChar == 'i') {
			lastChar = reverse_chars.pop();
			String num = "";
			while( lastChar != 'e' ) {
				num += lastChar;
				lastChar = reverse_chars.pop();
			}

			return num.toLong();
		}
		else if ( lastChar =~ /\d/) {
			String num = "";
			while( lastChar =~ /\d/ ) {
				num += lastChar;
				lastChar = reverse_chars.pop();
			}

			//integerize the num
			def end = num.toInteger();
			def range = 1 .. end;
			String string = "";
			range.each{ item ->
				string += reverse_chars.pop()  }
			return string;
		}
		else
		{
			println "Invalid input!";
		}
	}

	static encode( datastructure )
	{
		modifyMetaClasses();
		String result = datastructure.bencode();
		unmodifyMetaClasses();
		return result;
	}

	static modifyMetaClasses()
	{
		String.metaClass.bencode = {
			->
			String result = "" + delegate.length() + ":" + delegate;
			return result;
		}

		Long.metaClass.bencode = {
			->
			String result = "i" + delegate + "e";
			return result;
		}
		
		Integer.metaClass.bencode = {
			->
			String result = "i" + delegate + "e";
			return result;
		}

		List.metaClass.bencode = {
			->
			String result = "l";
			delegate.each{ item ->
				result += item.bencode() };
			result += 'e';
			return result
		}

		Map.metaClass.bencode = {
			->
			String result = 'd'
			delegate.each{ key, value ->
				result += key.bencode() + value.bencode();
			}
			result += 'e';
			return result;
		}

		String.metaClass.bdecode = {
			->
			return Gbencode.decode( delegate );
		}

	}

	static unmodifyMetaClasses()
	{
		//this doesn't actually work, so its a TODO
		//String.metaClass.bencode = null;
		//Integer.metaClass.bencode = null;
		//List.metaClass.bencode = null;
		//Map.metaClass.bencode = null;
	}

}