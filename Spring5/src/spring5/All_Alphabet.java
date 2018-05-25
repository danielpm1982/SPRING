package spring5;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("all_alphabet")
@Scope("singleton")
public class All_Alphabet implements All_Alphabet_Interface{
	@Autowired
	@Qualifier("letter_a")
	private Letter_Interface letter_a;
	@Autowired
	@Qualifier("letter_b")
	private Letter_Interface letter_b;
	@Autowired
	@Qualifier("letter_c")
	private Letter_Interface letter_c;
	@Autowired
	@Qualifier("letter_d")
	private Letter_Interface letter_d;
	@Autowired
	@Qualifier("letter_e")
	private Letter_Interface letter_e;
	@Autowired
	@Qualifier("letter_f")
	private Letter_Interface letter_f;
	@Autowired
	@Qualifier("letter_g")
	private Letter_Interface letter_g;
	@Autowired
	@Qualifier("letter_h")
	private Letter_Interface letter_h;
	@Autowired
	@Qualifier("letter_i")
	private Letter_Interface letter_i;
	@Autowired
	@Qualifier("letter_j")
	private Letter_Interface letter_j;
	@Autowired
	@Qualifier("letter_k")
	private Letter_Interface letter_k;
	@Autowired
	@Qualifier("letter_l")
	private Letter_Interface letter_l;
	@Autowired
	@Qualifier("letter_m")
	private Letter_Interface letter_m;
	@Autowired
	@Qualifier("letter_n")
	private Letter_Interface letter_n;
	@Autowired
	@Qualifier("letter_o")
	private Letter_Interface letter_o;
	@Autowired
	@Qualifier("letter_p")
	private Letter_Interface letter_p;
	@Autowired
	@Qualifier("letter_q")
	private Letter_Interface letter_q;
	@Autowired
	@Qualifier("letter_r")
	private Letter_Interface letter_r;
	@Autowired
	@Qualifier("letter_s")
	private Letter_Interface letter_s;
	@Autowired
	@Qualifier("letter_t")
	private Letter_Interface letter_t;
	@Autowired
	@Qualifier("letter_u")
	private Letter_Interface letter_u;
	@Autowired
	@Qualifier("letter_v")
	private Letter_Interface letter_v;
	@Autowired
	@Qualifier("letter_w")
	private Letter_Interface letter_w;
	@Autowired
	@Qualifier("letter_x")
	private Letter_Interface letter_x;
	@Autowired
	@Qualifier("letter_y")
	private Letter_Interface letter_y;
	@Autowired
	@Qualifier("letter_z")
	private Letter_Interface letter_z;
	@Override
    public String showAll() {
    	return "All Alphabet: "+letter_a.show()+" "+letter_b.show()+" "+letter_c.show()+" "+letter_d.show()+" "+letter_e.show()+" "+letter_f.show()+" "+letter_g.show()+" "+letter_h.show()+" "+letter_i.show()+" "+letter_j.show()+" "+letter_k.show()+" "+letter_l.show()+" "+letter_m.show()+" "+letter_n.show()+" "+letter_o.show()+" "+letter_p.show()+" "+letter_q.show()+" "+letter_r.show()+" "+letter_s.show()+" "+letter_t.show()+" "+letter_u.show()+" "+letter_v.show()+" "+letter_w.show()+" "+letter_x.show()+" "+letter_y.show()+" "+letter_z.show();
    }
	@Override
	public Set<Letter_Interface> getLetterSet(){
		return new HashSet<>(Arrays.asList(letter_a, letter_b, letter_c, letter_d, letter_e, letter_f, letter_g, letter_h, letter_i, letter_j, letter_k, letter_l, letter_m, letter_n, letter_o, letter_p, letter_q, letter_r, letter_s, letter_t, letter_u, letter_v, letter_w, letter_x, letter_y, letter_z));
	}
    @PostConstruct
    public void init() {
        System.out.println("Initializing "+this.getClass().getName()+" Bean...");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("Destroying "+this.getClass().getName()+" Bean.");
    }
}
